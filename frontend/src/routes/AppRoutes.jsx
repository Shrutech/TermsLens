import { BrowserRouter, Routes, Route } from 'react-router-dom';
import MainLayout from '../layouts/MainLayout';
import Home from '../pages/Home';
import AnalysisReport from '../pages/AnalysisReport';
import WhyMatters from "../pages/WhyMatters";
import AboutUs from "../pages/AboutUs";
import Analyze from "../pages/Analyze";

export default function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<MainLayout />}>
          <Route path="/" element={<Home />} />
          <Route path="/report" element={<AnalysisReport />} />
          <Route path="/why-matters" element={<WhyMatters />} />
          <Route path="/about-us" element={<AboutUs />} />
          <Route path="/analyze" element={<Analyze />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}