module.exports = {
  root: true,
  //parser: 'babel-eslint',
  'parserOptions': {
    'parser': '@typescript-eslint/parser',
    'ecmaVersion': 2015,
    'sourceType': 'module'
  },
  env: {
    browser: true,
    node: true
  },
  extends: '@nuxtjs/eslint-config-typescript',
  // required to lint *.vue files
  plugins: [
    'html'
  ],
  // add your custom rules here
  rules: {
    'space-before-function-paren': 'off'
  },
  globals: {}
}
