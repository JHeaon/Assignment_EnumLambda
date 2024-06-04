package sparta.enumtype;

import java.util.function.Function;

public enum OrderStatus {
    상품주문(status -> status.name().equals("주문접수")),
    주문접수(status -> status.name().equals("주문취소") || status.name().equals("상품발송")),
    주문취소(status -> false),
    상품발송(status -> status.name().equals("배송완료")),
    배송완료(status -> status.name().equals("교환") || status.name().equals("반품")),
    교환(status -> status.name().equals("재배송")),
    반품(status -> status.name().equals("환불")),
    재배송(status -> false),
    환불(status -> false),
    구매결정(status -> false);

    private final Function<OrderStatus, Boolean> isChangeableFunction;

    OrderStatus(Function<OrderStatus, Boolean> isChangeableFunction) {
        this.isChangeableFunction = isChangeableFunction;
    }

    public boolean isChangeableStatus(OrderStatus nextStatus) {
        // 구매 결정, 배송 완료, 취소 상태는 모든 다음 상태에 대해 변경 불가능
        return this.isChangeableFunction.apply(nextStatus);
    }
}

