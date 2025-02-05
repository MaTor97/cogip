import HomeOutImage from '../../assets/images/homeOutImage.png';
import HomeOutRectangle from '../../assets/images/homeOutRect.png';
import './HomeOutro.css'

function HomeIntro() {
    return (
        <div className='homeOutro'> 
            <div className="paragraph">
                <p>WORK BETTER IN YOUR COMPANY</p>
            </div>
            <img id='outImage' src={HomeOutImage} />
            <img id='rect' src={HomeOutRectangle} alt="" /> 
        </div>
    )
}

export default HomeIntro