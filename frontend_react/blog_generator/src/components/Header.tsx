import { useState } from 'react'
import LoginModal from '@components/account/LoginModal'

import { createStyles, makeStyles, Theme } from '@material-ui/core/styles'
import AppBar from '@material-ui/core/AppBar'
import Toolbar from '@material-ui/core/Toolbar'
import Typography from '@material-ui/core/Typography'
import Button from '@material-ui/core/Button'
import IconButton from '@material-ui/core/IconButton'
import MenuIcon from '@material-ui/icons/Menu'

const useStyles = makeStyles((theme: Theme) =>
  createStyles({
    root: {
      flexGrow: 1
    },
    menuButton: {
      marginRight: theme.spacing(2)
    },
    title: {
      flexGrow: 1
    },
  }),
)

export default function Header() {
  const classes = useStyles()
  const [isLoginModalOpen, setLoginModalOpen] = useState(false)

  function showLoginModal(): void {
    setLoginModalOpen(true)
  }

  function closeLoginModal(): void {
    setLoginModalOpen(false)
  }

  return (
    <div className={classes.root}>
      <AppBar position="static">
        <Toolbar>
          <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="menu">
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" className={classes.title}>
            {process.env.AXIOS_BASE_URL}
          </Typography>
          <Button color="inherit" onClick={showLoginModal}>Login</Button>
          <LoginModal open={isLoginModalOpen} handleClose={closeLoginModal}></LoginModal>
        </Toolbar>
      </AppBar>
    </div>
  )
}