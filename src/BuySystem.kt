//할인률 계산 fun
fun calculateTotal(price: Double, discountRate: Double): Double {
    return price * (1 - discountRate)
}

//calculateTotal에서 확인한 할인률로 물건을 구입하는 fun
fun buyProduct(member: Member) {
    println("-----상품 구입을 시작합니다.-----")

    ProductsRepository.printProductAll()

    println("구입할 상품의 제품번호를 입력해주세요.")
    val productnumber = readLine() ?: return
    val selectedId = productnumber.toIntOrNull()

    if (selectedId == null) {
        println("제품번호를 숫자로 입력해주세요.")
        return
    }

    val product = ProductsRepository.products.find { it.id == selectedId }

    if (product == null) {
        println("해당 상품이 존재하지 않습니다.")
        return
    }

    val finalPrice = calculateTotal(product.price, member.grade.discountRate)

    println("구매자: ${member.name} (${member.grade.description()})")
    println("상품명: ${product.name}")
    println("할인 전 가격: ${product.price}")
    println("할인 적용된 가격: $finalPrice")
}


fun loginOrRegister(): Member {
    val user = inputAndFindMember()
    return if (user != null) {
        println("로그인 완료되었습니다.")
        user
    } else {
        println("회원가입을 시작합니다.\n성함을 입력해주세요")
        val name = readLine() ?: throw IllegalArgumentException("이름은 비워둘 수 없습니다.")
        val newId = (AllMember.members.maxOfOrNull { it.id } ?: 9000) + 1
        val newMember = Member(name = name, id = newId)
        AllMember.members.add(newMember)
        println("회원가입이 완료되었습니다. 지급된 회원번호 분실에 유의해주세요.")
        newMember.PrintMember()
        newMember
    }
}
