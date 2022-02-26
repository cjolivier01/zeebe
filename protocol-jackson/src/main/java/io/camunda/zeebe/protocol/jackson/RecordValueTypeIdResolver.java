/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.1. You may not use this file
 * except in compliance with the Zeebe Community License 1.1.
 */
package io.camunda.zeebe.protocol.jackson;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.camunda.zeebe.protocol.record.RecordValue;
import io.camunda.zeebe.protocol.record.ValueType;
import java.util.Objects;

/**
 * A {@link com.fasterxml.jackson.databind.jsontype.TypeIdResolver} that maps a serialized {@link
 * RecordValue} value to a concrete implementation enum, e.g. {@link
 * io.camunda.zeebe.protocol.record.value.ImmutableVariableRecordValue}, based on the value type of
 * the record.
 */
final class RecordValueTypeIdResolver extends AbstractValueTypeIdResolver {

  @Override
  @NonNull
  protected Class<? extends RecordValue> mapFromValueType(@NonNull final ValueType valueType) {
    return ValueTypes.getTypeInfo(Objects.requireNonNull(valueType, "must specify a value type"))
        .getValueClass();
  }
}