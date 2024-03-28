import { useState } from "react";
import TemperatureInput from "./TemperatureInput";

function BoilingVerdict(props){ // 출력 하는 컴포넌트 선언
    if(props.celsius>=100){
        return <p> 물이 끓습니다. </p>
    }
    return <p> 물이 끓지 않습니다. </p>
}

function toCelsius(fahrenheit){ // 섭씨로 바꾸는 계산 함수 선언
    return ((fahrenheit-32)*5)/9;
}

function toFahrenheit(celsius){ // 화씨로 바꾸는 계산 함수 선언
    return (celsius*9)/5+32
}

function tryConvert(temperature, convert){ 
    const input = parseFloat(temperature);
    if(Number.isNaN(input)){
        return '';
    }
    const output = convert(input);
    const rounded = Math.round(output*1000)/1000;
    return rounded.toString();
}

// 얘가 부모 컴포넌트
export default function Calculator(props){ 
    const [temperature, setTemperature] = useState('');
    const [scale, setScale] = useState('c'); // State가 temperature, scale 두 개

    const handleCelsiusChange = (temperature)=>{ // 스테이트 섭씨로 바꿔주는 함수 선언 매개변수=temperature 
        setTemperature(temperature);
        setScale('c');
    }; 
    const handleFahrenheitChange = (temperature)=>{ // 스테이트 화씨로 바꿔주는 함수 선언
        setTemperature(temperature);
        setScale('f');
    };

    const celsius = 
        scale === "f" ? tryConvert(temperature, toCelsius) : temperature; // tryConvert 함수로 2개의 값을 보낸다. 입력받은 온도와  C로 변환한 값 
        
    const fahrenheit = 
        scale === "c" ? tryConvert(temperature, toFahrenheit) : temperature;

    return(<>
        <div>
            {/* TemperatureInput 컴포넌트 Change함수를 전달해서  */}
            <TemperatureInput 
                scale="c"
                temperature={celsius}
                onTemperatureChange={handleCelsiusChange}
            />
             <TemperatureInput
                scale="f"
                temperature={fahrenheit}
                onTemperatureChange={handleFahrenheitChange}
            />
            <BoilingVerdict celsius={parseFloat(celsius)}/> 
            {/* 물 끓는 지 아닌지 출력 컴포넌트 - 모든 온도를 섭씨로 변환 */}
        </div>
    </>)
}