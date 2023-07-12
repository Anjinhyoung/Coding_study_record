# 목차 

1. Git의 소개
2. Git의 기본 개념
3. Git과 Commit
4. Git과 Server - 로컬 저장소와 원격 저장소
5. Git과 Server2 - 로컬 저장소와 원격 저장소
6. Git과 branch
7. Git과 병합
8. Git과 충돌
9. Git과 Reset, Revert
10. Git 배포 관리와 태그

# 1. Git의 소개
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

## Git 설치(window 기준)
  * git이 설치가 되었는지 안 되었는지 확인하는 방법
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

# 2. Git의 기본 개념
## 파일 확장자
  * 해당 파일이 어떤 파일인지 알려주는 역할
  * 파일마다 정해져 있다.(.txt(메모장), .pptx(ppt), .xlsx(엑셀), ...)
  * 파일 확장하는 법
      * 파일에 들어가서 맨 위 '보기' -> '파일 확장자'

## GUI(GraphicU User Interface)
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
     * 'git commit -am 'commit 메세지''
   
   
