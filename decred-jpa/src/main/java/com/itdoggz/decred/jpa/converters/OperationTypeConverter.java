package com.itdoggz.decred.jpa.converters;

import com.itdoggz.decred.jpa.model.OperationType;
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
