import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import Category from './Category'
import App from './App'
import 'bootstrap/dist/css/bootstrap.css'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App/>
  </StrictMode>
)
