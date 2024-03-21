import Book from './Book';

export default function Library( props ){ 
    let successData = [ // 데이터 목록
        {name : '강호동', age:25},
        {name : '유재석', age:35},
        {name : '신동엽', age:45}
    ]
    return ( 
        <div>
            {/* <div>처음 만난 파이썬 300페이지</div>
            <div>처음 만난 파이썬 300페이지</div>
            <div>처음 만난 파이썬 300페이지</div> */}
            {/* <Book name="처음 만난 파이썬" numOfPage={300}/>
            <Book name="처음 만난 AWS" numOfPage={400}/>
            <Book name="처음 만난 리액트" numOfPage={500}/> */}
            {
                successData.map((data)=>{ // forEach는 리턴이 없다. map은 리턴을 줄 수 있어서 react에는 map을 자주 쓴다.
                    return(
                        <Book name={data.name} numOfPage={data.age}/>
                    )
                })
            }
        </div>
     );
} // {} : JSX에서 JS 코드 입력하겠다는 뜻
