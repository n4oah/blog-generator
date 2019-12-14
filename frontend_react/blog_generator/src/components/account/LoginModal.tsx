import Button from '@material-ui/core/Button'
import Dialog from '@material-ui/core/Dialog'
import DialogActions from '@material-ui/core/DialogActions'
import DialogContent from '@material-ui/core/DialogContent'
import DialogContentText from '@material-ui/core/DialogContentText'
import DialogTitle from '@material-ui/core/DialogTitle'
import ButtonBase from '@material-ui/core/ButtonBase'
import { Theme, makeStyles, createStyles } from '@material-ui/core/styles';

import { useCookies } from 'react-cookie'
import LoginType from '@src/enums/LoginType'

import googleLoginImg from '@public/image/accout/google-login-button.png'

const loginBtnImg = [
  {
    type: LoginType.GOOGLE,
    url: googleLoginImg,
    width: '100%',
    height: 97
  }
]

const useStyles = makeStyles((theme: Theme) => {
  createStyles({

  })
})

export interface Props {
  open: boolean
  handleClose: (() => void)
}

export default function FormDialog(props: Props) {
  const [, setLoginSucRedCokie] =  useCookies(['LOGIN_SUCCESS_URL'])

  function goToLoginPage(type: LoginType): void {
    
    setLoginSucRedCokie('LOGIN_SUCCESS_URL', 'http://localhost:3000/')

    switch (type) {
      case LoginType.GOOGLE:
        window.location.href='http://localhost/login/google'
        break
      case LoginType.NAVER:
        break
    }
  }

  return (
    <>
      <Dialog
        open={props.open}
        onClose={props.handleClose}
        aria-labelledby="form-dialog-title"
        fullWidth={true}
        maxWidth="sm">
        <DialogTitle id="form-dialog-title">로그인</DialogTitle>
        <DialogContent>
           <DialogContentText>
            로그인 유형을 선택하세요
          </DialogContentText>
          {loginBtnImg.map((img) => (
            <ButtonBase
              key={img.type}
              style={{
                width: img.width,
                backgroundImage: `url(${img.url})`,
                height: img.height
              }}
              onClick={() => goToLoginPage(img.type)}
            >
            </ButtonBase>
          ))}
        </DialogContent>
        <DialogActions>
          <Button onClick={props.handleClose} color="primary">
            Cancel
          </Button>
          <Button onClick={props.handleClose} color="primary">
            Subscribe
          </Button>
        </DialogActions>
      </Dialog>
    </>
  )
}