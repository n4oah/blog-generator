import App from 'next/app'
import Head from 'next/head'
import React from 'react'

import HeaderComponent from '../components/Header'
// import LoginModal from '../modals/LoginModal'

export default class RootApp extends App {
  render() {
    const { Component, pageProps } = this.props

    return (
      <div>
        <Head>
          <title>Hello React</title>
        </Head>
        <div>
          <header>
            <HeaderComponent></HeaderComponent>
          </header>
          <main>
            <Component {...pageProps} />
          </main>
          <footer>Footer</footer>
        </div>
      </div>
    )
  }
}
