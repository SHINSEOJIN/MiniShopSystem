var currentUser: Member? = null

fun main() {
    while (true) {
        println("\n==== 메뉴 ====")
        println("1. 로그인")
        println("2. 상품 목록 보기")
        println("3. 상품 구매")
        println("4. 종료")
        print("번호를 입력해주세요: ")

        when (readLine()?.trim()) {
            "1" -> currentUser = loginOrRegister()
            "2" -> ProductsRepository.printProductAll()
            "3" -> {
                if (currentUser != null) {
                    buyProduct(currentUser!!)
                } else {
                    println("로그인이 필요합니다. 먼저 로그인해주세요.")
                }
            }
            "4" -> {
                println("프로그램을 종료합니다.")
                return
            }
            else -> println("올바른 번호를 입력해주세요.")
        }
    }
}
