"use strict"
function CheckExtension(x){
    	   let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
    	   let maxSize = 5242880; // 5mb
    	   if(x.file >= maxSize){
    	      alert('파일사이즈 초과')
    	      return false
    	   }
    	   if(regex.test(x.fname)){
    	      alert('해당 종류의 파일은 업로드 할 수 없습니다. ')
    	      return false
    	   }
    	   return true
}



$.prototype.nullChecker =x=>{    //    x - 배열, input 여러개
    let flag = false
    let i = 0
    for ( i in x ){
        if( x[i] === ''){
            flag = true
        }
    }
    return flag
    

}