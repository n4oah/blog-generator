const env = require('./env-config.js')

module.exports = {
  presets: ['next/babel'],
  plugins: [
    '@babel/plugin-proposal-optional-chaining',
    ['transform-define', env]
  ]
}