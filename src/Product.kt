data class Product(val name: String, val price: Double, val id: Int) {
    //제품 한개의 정보 출력
    fun PrintProduct() {
        println("[제품번호 - $id] $name : $price")
    }
}

//제품목록리스트데이터
object ProductsRepository {
    val products = mutableListOf<Product>(
        Product("우유", 2000.0, 1001),
        Product("인형", 15000.0, 1002),
        Product("모코코", 300000.0, 1003)
    )

    //모든 제품목록 출력
    fun printProductAll() {
        println("현재 등록된 상품 목록:")
        products.forEach { it.PrintProduct() }
    }
}