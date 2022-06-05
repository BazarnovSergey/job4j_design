package ru.job4j.ood.lsp;

/**
 * Здесь нарушение lsp проявляется в виде усиления предусловий в подклассе
 */

public class Example3 {
    private static class Card {
        protected double balance;

        public boolean isPay(double sum) {
            if (balance < 0 || sum > balance) {
                throw new IllegalArgumentException("Пополните счет");
            }
            return true;
        }
    }

    private static class JuniorCard extends Card {

        @Override
        public boolean isPay(double sum) {
            if (balance < 0 || sum > balance) {
                throw new IllegalArgumentException("Пополните счет");
            }
            if (sum > 1000) {
                throw new IllegalArgumentException("Оплата покупки свыше 1000 рублей не разрешена");
            }
            return true;
        }
    }
}