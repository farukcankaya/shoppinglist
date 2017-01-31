package com.farukcankaya.shoppinglist.domain.mapper;

import com.farukcankaya.shoppinglist.data.entity.AmountEntity;
import com.farukcankaya.shoppinglist.data.entity.ProductEntity;
import com.farukcankaya.shoppinglist.data.entity.UnitEntity;
import com.farukcankaya.shoppinglist.domain.model.Amount;
import com.farukcankaya.shoppinglist.domain.model.Product;
import com.farukcankaya.shoppinglist.domain.model.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faruk Cankaya on 1/29/17.
 */

public class BasketsDataMapper {
    public static List<Product> convertProductsToDomain(final List<ProductEntity> productEntityList) {

        final ArrayList<Product> products = new ArrayList<>(productEntityList.size());
        if (productEntityList != null) {
            productEntityList.forEach(productEntity -> products.add(convertProductToDomain(productEntity)));
        }
        return products;
    }

    public static Product convertProductToDomain(final ProductEntity productEntity) {
        return Product.create(productEntity.getName(), productEntity.getColor(),
                convertAmountToDomain(productEntity.getAmount()));
    }

    public static Amount convertAmountToDomain(final AmountEntity amountEntity) {
        return Amount.create(amountEntity.getQuantity(), convertUnitToDomain(amountEntity.getUnit()));
    }

    public static Unit convertUnitToDomain(final UnitEntity unitEntity) {
        return Unit.create(unitEntity.getName(), unitEntity.getAbbreviation());
    }
}
