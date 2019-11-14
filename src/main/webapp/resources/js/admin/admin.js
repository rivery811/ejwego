"use strict";
var admin = admin || {};
admin = (() => {
    const WHEN_ERR = 'admin 호출하는 js가 없습니다.';
    let context, js, css, img;
    let navi_vuejs, auth_vuejs,cus_vue_js;
    let navijs;
    let init = () => {
        context = $.ctx()
        js = $.js()
        css = $.css()
        img = $.img()
        navi_vuejs = js + '/vue/navi_vue.js'
        navijs = js + '/cmm/navi.js'
        cus_vue_js= js+'/vue/cus_vue.js'
    }
    
    let onCreate = () => {
        alert('환영합니다.')
        init()
        $.when(
                $.getScript(navi_vuejs),
                $.getScript(navijs),
                $.getScript(cus_vue_js)
            ).done(() => {
                alert('admin onCreate done alert')
                setContentView()
            })
            .fail(() => {
                WHEN_ERR
            })
    }
    
    let setContentView = () => { //js  에서의 맨 처음 화면이다. 
        //      $('#login_form_id').remove()
        $('body').empty()
        $(navi_vue.navi()).appendTo('body')
        $('#nav_scroller_id').remove()
        navi.onCreate()

        $('<table id="tab">' +
                '  <tr>' +
                '  </tr>' +
                '</table>') // key값 무조건 string이기 때문에 '' 생량가능 value는 생략 불가, json이기때문에 , 로 속성 추가                            
            .css({
                width: '80%',
                height: '80%',
                border: '1px solid black',
                margin: '0 auto'
            })
            .appendTo('body') // body에 오버로딩

        $.each(
            [{
                    id: 'left',
                    width: '20%'
                },
                {
                    id: 'right',
                    width: '80%'
                }
            ],
            (i, j) => {
                $('<td id="' + j.id + '"></td>')
                    .css({
                        border: '1px solid #ddd',
                        width: j.width,
                        'vertical-align': 'top'
                    })
                    .appendTo('#tab tr')
            })

        $.each([ // name을 주고 구분
                {txt: '웹크롤링', name: 'web_crawl'},
                {txt: '고객관리', name: 'cust_mgmt'},
                {txt: '커뮤관리', name: 'comm_mgmt' },
                {txt: '상품조회', name: 'item_srch'},
                {txt: '상품수정', name: 'item_mod'},
                {txt: '상품삭제',name: 'item_del'}
            ],
            (i, j) => {
                $('<div name="' + j.name + '">' + j.txt + '</div>')
                    .appendTo('#left')
                    .click(function() {
                        $(this).addClass('active')
                        $(this).siblings().removeClass('active')
                        switch ($(this).attr('name')) {
                            case 'web_crawl':
                                web_crawl()
                                break
                            case 'cust_mgmt':
                            	customer_mgmt()

                                break
                            case 'comm_mgmt':
                            	comm_mgmt()

                                break
                            case 'item_mod':

                                break
                            case 'item_del':

                                break
                        }
                    })
            })
        $('#left div').css({
            border: '1px solid #ddd',
            margin: 'auto 0',
            'line-height': '50px'
        })
    }
    let web_crawl = () => {
    	   $('#right').empty()
           $('<form id="crawl_form_id" action="">'+
               '  <select name="site" size="1" >'+    //    multiple
               '  </select>'+
               '  <br>'+
   /*            '  <button id="news_btn">이동</button>'+
               '</form>'+
               '<form class="form-inline my-2 my-lg-0">'+*/
               '  <input class="form-control mr-sm-2" type="text" value= "스톤애견풀빌라" placeholder="Search" aria-label="Search">'+
//               '  <button id="crawl_btn" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>'+
               '</form>')
           .addClass('form-inline my-2 my-lg-0')
           .appendTo('#right')
           $('#crawl_form_id').css({padding : '0 auto', 'padding-top' : '5%'  })    //'padding-top' : '5%'
           $('#crawl_form_id select').css({ 'margin-left' : '30%' , 'margin-right' : '1%'})
           
           $.each(['직접입력','naver.com', 'daum.net', 'google.com', 'youtube.com'], (i, j)=>{
               $('<option value="'+ j +'">'+ j +'</option>')
               .appendTo('#crawl_form_id select')
           })
           
           $('<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>')
           .appendTo('#crawl_form_id')
           .click(e=>{
               e.preventDefault()        
               let arr = [$('form#crawl_form_id select[name="site"]').val(),
                           $('form#crawl_form_id input[type="text"]').val()]
               
               if( !$.fn.nullChecker(arr) ){            
           //        alert(arr[0] + ', '+ arr[1])
                   $.getJSON( context+ '/tx/crawling/' + arr[0] +'/' + arr[1], d=>{        // form 태그의 id란 뜻
                       alert(d.msg)
                   })
               }
           })
    }
    
	let customer_mgmt=()=>{
		$('#right').empty()
		$(cus_vue.cus()).appendTo('#right')
		$('<a>고객명단 대량 등록\n</a>').appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(context+'/tx/register/users',d=>{
			alert('등록인원'+d.userCount)
		})
		})
		$('<a>생성테이블\n</a>').appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(context+'/users/create/table',d=>{
			alert('등록인원'+d.msg)
		})
		})

			$('<a>데이터베이스 생성\n</a>').appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(context+'/create/db',d=>{
			alert('데이터베이스 등록'+d.msg)
		})
		})
		
		$('<a>어드민 생성\n</a>').appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(context+'/admins/create/admin',d=>{
			alert('어드민 등록'+d.msg)
		})
		})
				$('<a>어드민 삭제\n</a>').appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(context+'/admins/drop/admin',d=>{
			alert('어드민 등록'+d.msg)
		})
		})
		
		$('<a>이미지 생성\n</a>').appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(context+'/create/img',d=>{
			alert('이미지 등록'+d.msg)
		})
		})
		$('<a>고객정보삭제\n</a>').appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(context+'/tx/truncate/user',d=>{
			alert('이미지 등록'+d.msg)
		})
		})
		$('<a>고객정보삭제\n</a>').appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(context+'/tx/truncate/user',d=>{
			alert('이미지 등록'+d.msg)
		})
		})
				$('<a>직원등록\n</a>').appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(context+'/admins/admins',d=>{
			alert('직원 등록')
		})
		})
		
	}
	
	let comm_mgmt=()=>{
		$('<a>커뮤 디비\n</a>').appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(context+'/comm/comm',d=>{
			alert('커뮤 등록')
		})
		})
		$('<a>커뮤 컨텐츠\n</a>').appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(context+'/tx/content',d=>{
			alert('커뮤 컨텐츠 등록')
		})
		})
		
	}

    return {onCreate}

})();