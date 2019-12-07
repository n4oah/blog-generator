const withPlugins = require('next-compose-plugins')
const withLess = require('@zeit/next-less')
const path = require('path')
const withNextEnv = require('next-env')
require('dotenv-load')()

// fix: prevents error when .less files are required by node
if (typeof require !== 'undefined') {
    require.extensions['.less'] = file => {}
}

module.exports = withPlugins([
  withNextEnv({}),
  withLess({
    lessLoaderOptions: {
      javascriptEnabled: true,
    },
    webpack(config, options) {
      config.resolve.alias = config.resolve.alias || {}

      config.resolve.alias['@src'] = path.join(__dirname, 'src')
      config.resolve.alias['@components'] = path.join(__dirname, 'src', 'components')
      config.resolve.alias['@public'] = path.join(__dirname, 'public')
      return config
    }
  })
])
