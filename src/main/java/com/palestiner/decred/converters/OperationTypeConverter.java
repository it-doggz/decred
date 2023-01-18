package com.palestiner.decred.converters;

import com.palestiner.decred.model.OperationType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class OperationTypeConverter implements AttributeConverter<OperationType, Boolean> {

    @Override
    public Boolean convertToDatabaseColumn(OperationType operationType) {
        return operationType.getValue();
    }

    @Override
    public OperationType convertToEntityAttribute(Boolean bValue) {
        return OperationType.fromValue(bValue);
    }
}
