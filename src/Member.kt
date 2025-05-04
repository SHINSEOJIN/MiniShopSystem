data class Member(val name: String, val id: Int, val ismember: Boolean = true){
    fun PrintMember() {
        val status = if (ismember) "회원" else "비회원"
        println("[회원번호 - $id] 회원명: $name ($status)")
    }
}

object ProductsMember {
    val members = mutableListOf<Member>(
        Member("홍길동", 9001),
        Member("김이박", 9002, false),
        Member("박동길", 9003)
    )
    fun PrintMemberAll () {
        println("현재 등록된 멤버 목록")
        members.forEach { it.PrintMember() }
    }

}