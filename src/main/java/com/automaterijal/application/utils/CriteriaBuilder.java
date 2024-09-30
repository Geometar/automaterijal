package com.automaterijal.application.utils;

import java.util.Collection;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.impl.DSL;

public class CriteriaBuilder {
  private Condition condition;

  // Private constructor to prevent direct instantiation
  private CriteriaBuilder() {
    this.condition = DSL.noCondition();
  }

  // Static factory method to create a new instance
  public static CriteriaBuilder init() {
    return new CriteriaBuilder();
  }

  // Method to add a condition (chaining)
  public CriteriaBuilder addCondition(final Condition condition) {
    if (condition != null) {
      this.condition = this.condition.and(condition);
    }
    return this;
  }

  // Method to add a condition if the collection is not empty (chaining)
  public CriteriaBuilder addConditionIfNotEmpty(
      final Collection<?> collection, final Field<?> field) {
    if (collection != null && !collection.isEmpty()) {
      this.condition = this.condition.and(field.in(collection));
    }
    return this;
  }

  // Method to add a condition if the string is not empty (chaining)
  public CriteriaBuilder addConditionIfNotEmpty(final String value, final Field<?> field) {
    if (value != null && !value.isEmpty()) {
      this.condition = this.condition.and(field.likeIgnoreCase("%" + value + "%"));
    }
    return this;
  }

  // Method to add a condition if the boolean flag is true (chaining)
  public CriteriaBuilder addConditionIfTrue(final boolean condition, final Condition newCondition) {
    if (condition) {
      this.condition = this.condition.and(newCondition);
    }
    return this;
  }

  // Method to build the final condition
  public Condition build() {
    return this.condition;
  }
}
