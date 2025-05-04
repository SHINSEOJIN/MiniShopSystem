enum class MembershipGrade (val discountRate : Double) {
    BASIC(0.0),
    SILVER(0.05),
    GOLD(0.1);

    fun description(): String {
        return when (this) {
            BASIC -> "일반회원"
            SILVER -> "실버회원"
            GOLD -> "골드회원"
        }
    }
}