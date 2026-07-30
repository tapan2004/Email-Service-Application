import { useState } from 'react'
import './App.css'
import EmailSender from "./components/EmailSender.jsx";
import {Toaster} from "react-hot-toast";

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <EmailSender count={count} setCount={setCount} />
        <Toaster/>
    </>
  )
}
export default App
