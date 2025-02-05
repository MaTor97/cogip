import React from 'react';
import './Footer.css';
import { 
    PrintSVG, PhoneSVG, FacebookSVG, TwitterSVG, LinkedinSVG, YoutubeSVG, InstagramSVG, GooglePlusSVG, PinterestSVG, WifiSVG   
} from '../svg';   

const Footer = () => {
    return (
        <footer>
            <div className="footer">
                <div className="footer-section-one">
                    <div className="footer-logo">
                        <h2>COGIP</h2>
                    </div>
                    <div className="footer-about">
                        <div className="location">
                            <img src="" alt="" />
                            <p>Square des Martyrs, 6000 Charleroi</p>
                        </div>
                        <div className="phone-fax">
                            <div className="phone">
                                <PhoneSVG />
                                <p>(123) 456-7890</p>
                            </div>
                            <div className="fax">
                                <PrintSVG />
                                <p>(123) 456-7890</p>
                            </div>
                        </div>
                        <div className="social-media">
                            <p>Social Media</p>
                            <div className="social-media-icons">
                                <FacebookSVG />
                                <TwitterSVG />
                                <LinkedinSVG />
                                <YoutubeSVG />
                                <InstagramSVG />
                                <GooglePlusSVG />
                                <PinterestSVG />
                                <WifiSVG />
                            </div>
                        </div>
                    </div>
                </div>
                <div className="footer-section-two">
                    <nav className="footer-nav">
                        <ul>
                            <li><a href="/home">Home</a></li>
                            <li><a href="/invoices">Invoices</a></li>
                            <li><a href="/companies">Companies</a></li>
                            <li><a href="/contact">Contact</a></li>
                            <li><a href="/privacy-policy">Privacy Policy</a></li>
                        </ul>
                    </nav>
                    <div className="footer-copyright">
                        <p>&copy; 2022 Cogip Inc.</p>
                    </div>
                </div>
            </div>
        </footer>
    );
};

export default Footer;