module.exports = {
  root: true,
  env: {
    node: true,
  },
  extends: [
    'plugin:vue/essential',
    // '@vue/airbnb',
  ],
  parserOptions: {
    parser: 'babel-eslint',
  },
  rules: {
    'no-console': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
    "eol-last": 0,
    "indent": "off",
    "comma-dangle": ["error", "never"],
    'vue/script-indent': ['warn', 2, {
      'baseIndent': 1
}],
    'max-len': 'off',
  },
};
