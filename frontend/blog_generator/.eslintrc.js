module.exports = {
  root: true,
  parserOptions: {
    "parser": "babel-eslint",
    "ecmaVersion": 2015,
    "sourceType": "module"
  },
  env: {
    browser: true,
    node: true
  },
  extends: '@nuxtjs/eslint-config-typescript',
  plugins: [
    'html'
  ],
  rules: {},
  globals: {}
}
