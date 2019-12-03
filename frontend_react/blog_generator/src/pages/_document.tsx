import Document, { Html, Head, Main, NextScript } from 'next/document';
import { ServerStyleSheets } from "@material-ui/styles";

class MyDocument extends Document {
  /*
   * @DATE 2019/12/01
   * 렌더링 하기 전 material-ui 스타일 적용
   * 
   * 적용하기 전엔 페이지 새로고침 후 커스텀 스타일시트가 깨지는 이슈가 있었음 (yarn run dev 모드에서만)
   * SSR 관련 이슈로 추정
   * 정확한 이유를 정리해볼 필요가 있음.
   * 
   * 참조자료:
   * https://min9nim.github.io/2018/11/nextjs-getInitialProps/
   * https://salgum1114.github.io/nextjs/2019-05-28-nextjs-static-website-5/
   * https://medium.com/manato/ssr-with-next-js-styled-components-and-material-ui-b1e88ac11dfa
   */
  static async getInitialProps(ctx: any) {
    const sheet = new ServerStyleSheets();
    const originalRenderPage = ctx.renderPage;

    try {
      ctx.renderPage = () => originalRenderPage({
        enhanceApp: (App: any)=> (props: any) => sheet.collect(<App {...props} />)
      });

      const initialProps = await Document.getInitialProps(ctx);
      return {
        ...initialProps,
        styles: (
          <>
            {initialProps.styles}
            {sheet.getStyleElement()}
          </>
        )
      }
    } finally {
      ctx.renderPage(sheet)
    }

  }
  render() {
    return (
      <Html>
        <Head>
          <link rel="shortcut icon" type="image/png" href="../static/favicon.ico" />
          <style>{`body { margin: 0 } /* custom! */`}</style>
          <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        </Head>
        <body className="custom_class">
          <Main />
          <NextScript />
        </body>
      </Html>
    )
  }
}

export default MyDocument;