
        // var: 함수레벨, let, const: block 레벨.
        var name = 'Hwang';
        // function myfunc()
        {
            var name = 'Hong';
            console.log(name);
        }
        // myfunc();
        console.log(name);

        let age = 20;
        // function myfunc2()
        {
            let age = 22;
            console.log(age);
        }
        // myfunc2();
        console.log(age);
        obj.show();
        document.body.addEventListener('click',function(){
            console.log(this);
        })
        // 1. 전역영역: window 객체.
        // 2. 함수: window 객체.
        // 3. 객체: object
        // 4. 이벤트: 이벤트 실행 대상.
        //console.log(this);

        // let show = 'Hello';

        // function show(){
        //     console.log('show');

        // }

        // () 실행.
        let show = function(){
            console.log('show');
            // return undefined;
            return '반환값';
        }
        console.log(show());

        (function(){
            console.log('익명함수');
        })();

        // 함수명명 규칙.
        function showMyName(){
            console.log('홍길동');
        }

        // 상수선언.
        const height = 167.9;
        // height = 169;

        const friend = {
            name: '홍길동',
            phone: '010-1111'
        }
        friend.phone = '010-2222';

        // friend = {}
        