package com.adatech.ConsumoDeAPIExterna.client;

public record ExternalProduct(
        String title,
        String description,
        double price,
        double discountPercentage,
        double rating,
        int stock,
        String brand,
        String category) {
}
