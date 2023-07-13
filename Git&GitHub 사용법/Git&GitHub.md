# 목차 

1. [Git의 소개](#git-의소개)
   * [버전](#버전)
   * [버전관리시스템](#버전관리시스템)
   * [Git의 특징](#git의-특징)
   * [Git 설치](#git-설치)
   * [Git 시작](#git-시작)
2. [Git의 기본 개념](#git의-기본-개념)
   * [파일 확장자](#파일-확장자)
   * [GUI](#gui)
5. [Git과 Commit](#git과-commit)
6. [Git과 Server-로컬 저장소와 원격 저장소](#git과-server-로컬-저장소와-원격-저장소)
7. [Git과 Server2-로컬 저장소와 원격 저장소](#git과-server2-로컬-저장소와-원격-저장소)
8. [Git과 branch](#git과-branch)
9. Git과 병합
10. Git과 충돌
11. Git과 Reset, Revert
12. Git 배포 관리와 태그

# Git의 소개
## 버전
  * 프로그램이나 파일이 수정된 사항이 있으면 버전이 업데이트 되었다.
  * ex) 1.1ver, 1.2ver, 1.3ver 1.x는 보통 서브 버전이라 말하고 자잘한 부분들을 수정한 거라 생각하면 된다.
  * ex) 1.1 -> 2.1  이런 식으로 x.1 '.'앞에 숫자가 바뀌었으면 대대적으로 수정한 거라 생각하면 된다.

## 버전관리시스템
* git:수많은 버전을 쉽게 관리하도록 도와주는 도구

## Git의 특징
1. 분산형 버전관리 시스템
   * 원격저장소(github)와 로컬저장소(개인컴퓨터)('저장소'를 '래퍼지토리'라 할 수 있음)
   * 인터넷 연결이 없더라도 작업을 할 수 있다.
2. 원격 저장소에 있는 코드를 공유할 수 있다.
   * 효율적인 협업이 가능하다.
3. 파일들의 수정, 삭제, 추가 등에 대한 모든 변경사항이 기록된다.
4. 오픈소스를 보며 코드의 지식을 넓힐 수 있다.

## Git 설치
  * git이 설치가 되었는지 안 되었는지 확인하는 방법(window 기준)
    * cmd(명령 프롬프트)에서 git --version치기
    * 설치가 되지 않았으면 unknown option: git --version이라고 나올거다.
  * git이 설치가 되지 않았으면
1. [Git홈페이지에 들어가기](https://git-scm.com/)
2. 홈페이지 첫 화면 오른쪽에 download for windows 클릭
3. 맨 위 Download for Windows 아래 click here to download 클릭
4. 설치 파일을 실행
5. 기본설정유지한 채로 Next 
       

## Git 시작
  * 로컬레포지토리 설정
      * 먼저 레포지토리를 설정한 새로운 파일을 만든다.
      * cmd(cmd로 설치할 경우 만든 파일까지 이동해야 한다.) 혹은 만든 파일에 마우스 오른쪽 버튼 눌러서 git bash here 누르고 git init 치기
      * .git 이라는 숨김 폴더가 만들어 지면서 해당 폴더를 로컬저장소로 사용할 수 있게 된다.
      * 최초 한 번만 실행 해주면 된다.
      * But (.git)폴더를 삭제했다면 다시 로컬 저장소로 설정하기 위해 git init을 실행 해줘야 한다.

# Git의 기본 개념
## 파일 확장자
  * 해당 파일이 어떤 파일인지 알려주는 역할
  * 파일마다 정해져 있다.(.txt(메모장), .pptx(ppt), .xlsx(엑셀), ...)
  * 파일 확장하는 법
      * 파일에 들어가서 맨 위 '보기' -> '파일 확장자'

## GUI
  * Graphic User Interface
  * 사용자가 편히 사용할 수 있도록 버튼이나 아이콘이나 같은 그래픽 기반의 사용환경(마우스 오른쪽 버튼 -> git gui here)

## CLI(command Line Interface)
  * 명령어 기반 사용환경(마우스 오른쪽 버튼 -> git bash here)

## Sourcetree
  * git을 쉽게 사용할 수 있도록 도와주는 외부 gui tool
  * 설치하는 방법(window 기준)
    1. [소스트리 홈페이지 들어가기](https://www.sourcetreeapp.com/)
    2. 홈페이지 첫 화면에 dowload for window클릭해서 다운로드하기
    3. 실행하면 맨 처음 화면에 오른쪽에 Bitbucket을 클릭해서 회원가입하기(회원가입을 해야 사용할 수 있다.)

## Git의 공간 분리
  * 동작과 이력을 효율적으로 처리하기 위해서 저장공간을 논리적으로 분리(3가지 종류가 있다.)
    1. 작업공간(working directory/working tree)
    2. 임시저장공간(stage)
    3. 실직적으로 저장되고 기록되는 공간(repository)
    4. 
## 작업 공간(working tree)
   * 작업을 하는 공간
   * 로컬저장소에 접근하여 파일을 생성, 수정 그리고 저장하는 공간
   * 스테이지(stage) 영역과 맞닿아 있다.
   * 작업 공간에 새롭게 만들어진 파일들은 최초 모두 untracked  상태이다.
   * 따라서 해당 파일들을 수정 사항을 반영하고 싶다면 tracked 상태로 바꾸어 주어야 한다.
     * `git add '파일명'`
   * 해당 명령어를 실행하면 해당 파일이  tracked  상태로 변경
     
## 깃 명령어(CLI)
   * git으로 시작한다.
   * 설치 명령어
      * `git init`
   * track 상태로 바꾸기
      * `git add '파일명'`
   * 상태 확인 명령어
      * `git status`
    
## 임시저장공간(stage)
   * tracked 된 파일들을 관리하는 영역
   * 작업 공간과 연결되어있다.
   * tracked 된 파일들의 추적상태를 잠시 복사하여 저장한다.
   * stage 영역에 저장된 파일들은 모두 tracked 상태가 된다. stage에 등록이 된다.
   * 최종적인 파일의 변화를 영구적으로 저장하기 위해서는 모든 파일의 상태가 stage 상태가 되어야 한다.
   * unstage 상태는 스테이지 영역에 있는 파일과 working directory 안의 파일이 서로 차이가 있을 때를 의마한다.
   * stage에 올라가지 않은, 작업공간에 새롭게 만들어진 파일(untracked 파일)도 unstage 상태라고 할 수 있다.
   * 원본과 수정본의 기록을 구분하기 위해 modified unmodified로 나누어 관리
   * working directory
     * tracked
       * `파일1(수정 사항 없음) -> unmodified 상태 -> stage 상태`
       * `파일2(수정 사항 있음) -> modified 상태 -> unstage 상태`
     * untracked
       * `파일3(stage에 추가하지 않은 상태) -> unstage 상태`

 # Git과 Commit
 ## 작업 공간 <--->  stage <---> repository
   * stage 올리기(untracked파일 혹인 modified된 파일)
     * `git add '파일명'`
     * `모든 파일을 stag에 올리고 싶다면 파일명 자리에 *을 사용한다.`
   * stage에서 내리기
     * `git rm cached '파일명'`
     * `모든 파일을 stage에 내리고 싶다면 파일명 자리에 *을 사용한다.`
   * commit
     * stage 상태의 파일(modifed 혹은 untracked된 파일은 안 됨)들을 영구적으로 저장
     * commit(영구저장) 메시지를 남겨야 한다.(권장사항)
     * `git commmit`
   * vi editor(commit 메세지 입력 편집기)
     * #은 주석(해석하지 않음)
     * esc i --> 내용 삽입
     * esc:
          * wq 엔터 --> 해당 commit 메세지가 적용된다.
   * commit 단축옵션(-m)
     * `git commit -m 'commit 메세지'`
     * vi 에디터를 열지 않고도 간단하게 작은 따움표나 쌍따움표 안쪽 내용을 commit 메세지로 작성할 수 있도록 도와주는 옵션
   * 커밋 단축옵션(-a)
     * tracked 되어 modified 된 파일에만 적용할 수가 있다.
     * `git commit -a`
     * add되지 않은(unstage 된 파일)을 commit하고 싶은데 매번 add 명령어를 실행시키가 귀찮다면 사용(-a)
   * -am
     * 두 옵션을 섞어서 사용할 수 있다.
     * `git commit -am 'commit 메세지'`
     * 
 # Git과 Server-로컬 저장소와 원격 저장소
 |Git|GitHub|
 |---|---|
 |로컬 저장소|원격 저장소|
 ## GitHub(원격저장소)와 로컬 저장소 연결
   1. 원격저장소 만들기
      * GitHub 로그인 > repositoty 만들기
   2. 내가 만든 원격 저장소와 로컬 저장소 연결
      1. `git branch - M main`
          * branch를 main으로 변경
      2. `git remote add origin(별칭) 원격저장소주소(Github주소)`
          * git 로컬 저장소와 연결된 원격 저장소를 설정
          * 원격 저장소가 주소가 너무 기니깐 origin(별칭)이라고 부름
          * 그래서 origin말고 ex) hi, abc 등등 지어도 상관 없음
   * `git remote`
       * 해당 레포지토리와 연결된 원격저장소를 알려줘
       * origin(별칭)이라고 뜨면 잘 연결됨
   * `git push origin(별칭) branch 이름`
       * 맨 처음 git push origin(별칭) main을 입력하면 깃허브 로그인하라고 창이 업로드 됨
       * (로그인 하면 된다. 확인 절차라 생각하면 된다.)
       * `git push origin main`
          * origin이라는 별칭을 가진 원격저장소의 main이라는 branch에다 업로드 하겠다.
   * `git push -u 별칭 branch 이름`
       * 해당 옵션을 사용하면 별칭과 브랜치 이름은 생략 가능하다.
    
   # Git과 Server2-로컬 저장소와 원격 저장소
   * `git remote add 원격저장소 별칭(origin) 원격 저장소 주소(GitHub 주소)`
      * 해당 주소의 원격 저장소를 별칭으로 추가(연결)
   *  `git remote`
      * 연결시킨 원격 저장소 별칭 확인
   *  `git remote -v`
      * 연결시킨 원격 저장소 별칭과 주소 확인
   * `git remote rename origin revised(바꿀 원격 저장소 이름) `
      * 원격 저장소 별칭 이름 바꾸기 origin -> revised
   * `git remote show 원격 저장소 별칭(origin)`
      * 원격 저장소의 상세 내용 확인(브랜치)
   * `git clone (다른 사람)원격저장주소`
      *  다른 사람의 원격 저장소의 파일(수정사항, 커밋도 볼 수 있음)
      *  원격저장소의 커밋내용, 수정사항 등 모든 과정을 복제
   * `git log`
      * 커밋 내용(로그)을 확인할 수 있으며 q를 누르면 원래대로 돌아옴
      * 각각의 커밋 내용은 고유의 id값을 갖고 있다.
      * 각각의 id는 중복이 되지 않으므로 그 id로 커밋을 구분한다.
   * `git pull `
      * 원격 저장소의 최신 커밋 상태를 로컬 저장소로 다운로드
   * `git fetch (다른 사람)원격저장소주소`
      * 원격 저장소에 있는 내용들을 임시 저장
      * git pull하면 되는데 왜 이 방법을 쓰냐하면 바이러스 방지, 메모리 초과 방지(단순 비교용으로만 사용할 경우 굳이 git pull을 사용할 필요가 없음)
      * 만약에 'fetch'를 사용해서 다운 받고 싶으면 `git merge origin(별칭)/main(브랜치 이름)`
   * `git remote rm 원격 저장소 별칭`
      * 원격 저장소의 별칭 삭제
# Git과 branch
## 브랜치 정보
   * branch(브랜치)
       * 나뭇가지, 분기점
       * 원본을 기반으로 분리하여 작업할 수 있도록 도와준다.
       * 항상 안정된 코드를 유지함과 더불어 실험적인 작업을 시도할 수 있다.
       * 일종의 가상 폴더
   * master branch
       * git에서 기본적으로 만들어진 브랜치
   * head (pointer)
       * 가장 마지막에 커밋된 상태를 가리키는 지시자(저장공간)
       * 새롭게 커밋이 되거나 수정, 변경이 될 때 head가 알고 있는 커밋을 보고 비교하면 속도가 빠르기 때문이다.

   ### Take a picture
   1. ![git init](https://github.com/Anjinhyoung/TIL-Today-I-Learned-/assets/117788976/8cebd64f-2c0d-4a32-ab88-5a13e0410a7e)
       - 맨처음 git init을 설치하면 'master'브랜치가 생성이 된다.
   2. ![master 브랜치](https://github.com/Anjinhyoung/TIL-Today-I-Learned-/assets/117788976/8aa3431d-24bd-4e7f-87e1-c7cf264e17de)
       - 이런 식으로 생각하면 된다.
       - 이제 Master 브랜치에다가 test1 파일을 만들어 보자.
       * git 로컬 브랜치 만들기
   3. ![test1파일 생성](https://github.com/Anjinhyoung/TIL-Today-I-Learned-/assets/117788976/593902aa-fd4b-43b4-b73e-10bf86f3b47d)
   4. ![test1 파일 생성2](https://github.com/Anjinhyoung/TIL-Today-I-Learned-/assets/117788976/677c4a4a-aa82-40c2-be9c-57657cc12bfb)
       - 이런 식으로 생각하면 된다.
       - 이제 master 브랜치에다가 'abc' 브랜치를 만들어 보자.
           * `git branch 브랜치 이름 (커밋ID)`
             * 커밋ID를 생략하면 마지막 커밋(head)를 기점으로 새로운 브랜치가 생성
             * 브랜치 이름은 -. 으로는 시작할 수 없고 띄어쓰기 ~^?* 특수문자는 불가능 이미 존재하는 브랜치 이름도 불가능
             * git -flow기법을 참고하여 브랜치 이름을 짓는 것도 좋다. (구글에 git -flow 검색)
   5. ![abc 브랜치 생성](https://github.com/Anjinhyoung/TIL-Today-I-Learned-/assets/117788976/a25728cb-6da0-44c5-bc1d-d0af633c082f)
       - 이런 식으로 생각하면 된다.
       - 이제 abc브랜치에다가 test2 파일을 만들어 보자.
           * 브랜치 이동
           * `git checkout 이동할 브랜치`
           * `git checkout -`
             * 이전 브랜치로 이동한다 '-'는 리눅스에서 '이전'이라는 명령어를 갖고 있다.
             * commit이 완료되지 않으면 (stage에 남아있다.) 다른 브랜치로 이동 불가
           * `git checkout -b 브랜치명`
             * 브랜치 생성과 이동을 동시에
   6. ![test2 파일 생성](https://github.com/Anjinhyoung/TIL-Today-I-Learned-/assets/117788976/bca50063-1a20-46e7-b5f5-5c39653e8288)
   7. ![test2파일 생성2](https://github.com/Anjinhyoung/TIL-Today-I-Learned-/assets/117788976/98f3c3e0-d29a-4201-876c-bd2c37803b6a)
       - 이런 식으로 생각하면 된다.
       - 이제 master 브랜치를 보면
   8. ![master 브랜치 상황](https://github.com/Anjinhyoung/TIL-Today-I-Learned-/assets/117788976/6276e040-c6c7-434a-a0ae-2ba2f76d94f5)
       - test2 파일 없다. test2는 abc브랜치에다가 만들었으니깐 master 브랜치에는 test2 파일이 안 보인다.
 ## GitHub 브랜치
   * github의 기본 브랜치 이름은 main이다.
   * 따라서 보통은 깃허브에 연결할 때 git의 기본 브랜치인 master를 main으로 수정하여 사용한다.
   * git branch -M main 이런 식으로 수정
   * 현재 위치한 브랜치가 main을 수정

 ## GitHub 브랜치 만들기
   *  `git push -u 원격 저장소 별칭 브랜치 이름`
       *  원격 저장소로 로컬 branch 전송하기
   *  `git remote show 원격저장소 별칭`
       *  원격저장소 브랜치와 로컬브랜치 정보 확인
   *  `git push origin 브랜치이름:원격 저장소 브랜치 이름`
       *  로컬 브랜치와 원격 저장소 브랜치가 서로 같다면 push할 때 혹은 pull할 때 생략할 수 있다.
       *  하지만 이름이 다르면 git push 원격 저장소 별칭 원격 저장소 브랜치명으로 생략하지 못하고 사용한다.
   








   
   
