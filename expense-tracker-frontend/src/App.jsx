import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './Home';
import Category from './Category';
import Expenses from './Expenses';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/home' element={<Home />} />
        <Route path='/categories' element={<Category />} />
        <Route path='/expenses' element={<Expenses />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
