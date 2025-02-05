import HomeImg from '../../assets/images/homeImage.png';

function HomeIntro() {
    return (
        <div className='homeIntro'> 
            <div className="paragraph">
                <p>MANAGE YOUR CUSTOMERS AND INVOICES EASLY</p>
            </div>
            <img src={HomeImg} />           
        </div>
    )
}

export default HomeIntro