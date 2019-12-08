const withPlugins = require('next-compose-plugins')
const withLess = require('@zeit/next-less')
const path = require('path')
// const Dotenv = require('dotenv-webpack')

// fix: prevents error when .less files are required by node
if (typeof require !== 'undefined') {
    require.extensions['.less'] = file => {}
}

module.exports = withPlugins([
  withLess({
    lessLoaderOptions: {
      javascriptEnabled: true,
    },
    webpack(config, options) {
      /*
       * config.rsvole.alias
       */
      config.resolve.alias = config.resolve.alias || {}

      config.resolve.alias['@src'] = path.join(__dirname, 'src')
      config.resolve.alias['@components'] = path.join(__dirname, 'src', 'components')
      config.resolve.alias['@public'] = path.join(__dirname, 'public')
      config.resolve.alias['@api'] = path.join(__dirname, 'src/apis')

      /*
       * config.plugins
       */
      /*
      config.plugins = config.plugins || []

      config.plugins.push(
        new Dotenv({
          path: path.join(__dirname, '.env'),
          systemvars: true
        })
      )
      */

      return config
    }
  })
], {
  publicRuntimeConfig: {
    API_URL: process.env.API_URL
  }
})