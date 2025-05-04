data class Member(
    val name: String,
    val id: Int,
    val ismember: Boolean = true,
    val grade: MembershipGrade = MembershipGrade.BASIC
) {
    //회원정보출력
    fun PrintMember() {
        val status = if (ismember) "회원" else "비회원"
        println("[회원번호 - $id] 회원명: $name ($status, 등급: ${grade.description()})")
    }
}

//회원데이터리스트
object AllMember {
    val members = mutableListOf<Member>(
        Member("홍길동", 9001, true, MembershipGrade.GOLD),
        Member("김이박", 9002, false),
        Member("박동길", 9003, true, MembershipGrade.SILVER)
    )

    fun PrintMemberAll() {
        println("현재 등록된 멤버 목록")
        members.forEach { it.PrintMember() }
    }
}

//회원이 맞는지 확인하는 fun
fun findMember(name: String, id: Int): Member? {
    return AllMember.members.find { it.name == name && it.id == id }
}

//회원정보 입력값과 회원정보 비교
fun inputAndFindMember(): Member? {
    println("이름과 id를 입력해주세요.")
    val input = readLine()!!.split(Regex("[\\s,]+"))

    if (input.size != 2) {
        println("이름과 id를 입력해주세요. (ex) 김서진 9000")
        return null
    }

    val name = input[0]
    val id = input[1].toIntOrNull()

    if (id == null) {
        println("id는 숫자로 입력해아합니다.(ex) 김서진 9000")
        return null
    }
    val found = findMember(name, id)

    if(found != null){
        println("회원이 확인되었습니다.")
        found.PrintMember()
    }else{
        println("회원이 아닙니다.")
    }
    return found
}


//회원X -> 신규회원가입 (이름입력 시 id 부여 (기존 id의 마지막숫자 +1)
fun addmember() {
    val member = inputAndFindMember()

    if(member == null) {
        println("회원가입을 시작합니다.\n성함을 입력해주세요")
        val name = readLine() ?: return

        val newId = (AllMember.members.maxOfOrNull { it.id } ?: 9000) + 1
        val newMember = Member(name = name, id = newId)

        AllMember.members.add(newMember)

        println("회원가입이 완료되었습니다. 지급된 아이디 분실에 유의해주세요.")
        println("회원정보:")
        newMember.PrintMember()
    }else{
        println("이미 가입된 회원입니다.")
    }
}