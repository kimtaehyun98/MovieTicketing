package movieTicketing.movieTicketing.domain;

public enum Grade {
    BRONZE, SILVER, GOLD, VIP
    // BRONZE 등급은 할인 없음
    // SILVER 등급은 5% 할인
    // GOLD 등급은 10% 할인
    // VIP 등급은 20% 할인
    // 이때 할인은 전체 금액에 대해 적용되며 각 등급은 누적 사용 금액이 100만원 단위로 증가할때 변동된다.
    // ex) 누적 사용 금액 = 100만원 = SILVER, 200만원은 = GOLD ...
}
