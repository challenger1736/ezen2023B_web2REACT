import Comment from "./Comment";

export default function CommentList(props){

    //샘플
    let response = [ {name : '유재석' , content : '안녕하세요1'} ,
    {name : '강호동' , content : '안녕하세요2'} ,
    {name : '신동엽' , content : '안녕하세요3'} ];
    
    
    return(
    <div>
            {response.map((data)=>{ // forEach는 리턴이 없다. map은 리턴을 줄 수 있어서 react에는 map을 자주 쓴다.
                return(
                    <Comment 
                        name={data.name} 
                        text={data.content}
                    />
                )
            })}
            {/* {} 중괄호 쳐줘야 map을 실행시키는 js를 실행할 수 있다잉 */}
            
    </div>

    )
}