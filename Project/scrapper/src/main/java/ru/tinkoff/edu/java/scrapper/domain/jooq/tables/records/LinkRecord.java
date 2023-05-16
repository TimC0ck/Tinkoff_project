/*
 * This file is generated by jOOQ.
 */
package ru.tinkoff.edu.java.scrapper.domain.jooq.tables.records;


import jakarta.validation.constraints.Size;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

import ru.tinkoff.edu.java.scrapper.domain.jooq.tables.Link;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "https://www.jooq.org",
                "jOOQ version:3.17.6"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LinkRecord extends UpdatableRecordImpl<LinkRecord> implements Record6<Long, String, LocalDateTime, LocalDateTime, Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>LINK.ID</code>.
     */
    public void setId(@NotNull Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>LINK.ID</code>.
     */
    @NotNull
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>LINK.LINK</code>.
     */
    public void setLink(@NotNull String value) {
        set(1, value);
    }

    /**
     * Getter for <code>LINK.LINK</code>.
     */
    @jakarta.validation.constraints.NotNull
    @Size(max = 1000000000)
    @NotNull
    public String getLink() {
        return (String) get(1);
    }

    /**
     * Setter for <code>LINK.LAST_UPDATE</code>.
     */
    public void setLastUpdate(@NotNull LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>LINK.LAST_UPDATE</code>.
     */
    @jakarta.validation.constraints.NotNull
    @NotNull
    public LocalDateTime getLastUpdate() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>LINK.LAST_ACTIVITY</code>.
     */
    public void setLastActivity(@NotNull LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>LINK.LAST_ACTIVITY</code>.
     */
    @jakarta.validation.constraints.NotNull
    @NotNull
    public LocalDateTime getLastActivity() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>LINK.OPEN_ISSUES_COUNT</code>.
     */
    public void setOpenIssuesCount(@Nullable Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>LINK.OPEN_ISSUES_COUNT</code>.
     */
    @Nullable
    public Integer getOpenIssuesCount() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>LINK.ANSWER_COUNT</code>.
     */
    public void setAnswerCount(@Nullable Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>LINK.ANSWER_COUNT</code>.
     */
    @Nullable
    public Integer getAnswerCount() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Row6<Long, String, LocalDateTime, LocalDateTime, Integer, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    @NotNull
    public Row6<Long, String, LocalDateTime, LocalDateTime, Integer, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    @NotNull
    public Field<Long> field1() {
        return Link.LINK.ID;
    }

    @Override
    @NotNull
    public Field<String> field2() {
        return Link.LINK.LINK_;
    }

    @Override
    @NotNull
    public Field<LocalDateTime> field3() {
        return Link.LINK.LAST_UPDATE;
    }

    @Override
    @NotNull
    public Field<LocalDateTime> field4() {
        return Link.LINK.LAST_ACTIVITY;
    }

    @Override
    @NotNull
    public Field<Integer> field5() {
        return Link.LINK.OPEN_ISSUES_COUNT;
    }

    @Override
    @NotNull
    public Field<Integer> field6() {
        return Link.LINK.ANSWER_COUNT;
    }

    @Override
    @NotNull
    public Long component1() {
        return getId();
    }

    @Override
    @NotNull
    public String component2() {
        return getLink();
    }

    @Override
    @NotNull
    public LocalDateTime component3() {
        return getLastUpdate();
    }

    @Override
    @NotNull
    public LocalDateTime component4() {
        return getLastActivity();
    }

    @Override
    @Nullable
    public Integer component5() {
        return getOpenIssuesCount();
    }

    @Override
    @Nullable
    public Integer component6() {
        return getAnswerCount();
    }

    @Override
    @NotNull
    public Long value1() {
        return getId();
    }

    @Override
    @NotNull
    public String value2() {
        return getLink();
    }

    @Override
    @NotNull
    public LocalDateTime value3() {
        return getLastUpdate();
    }

    @Override
    @NotNull
    public LocalDateTime value4() {
        return getLastActivity();
    }

    @Override
    @Nullable
    public Integer value5() {
        return getOpenIssuesCount();
    }

    @Override
    @Nullable
    public Integer value6() {
        return getAnswerCount();
    }

    @Override
    @NotNull
    public LinkRecord value1(@NotNull Long value) {
        setId(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value2(@NotNull String value) {
        setLink(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value3(@NotNull LocalDateTime value) {
        setLastUpdate(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value4(@NotNull LocalDateTime value) {
        setLastActivity(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value5(@Nullable Integer value) {
        setOpenIssuesCount(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value6(@Nullable Integer value) {
        setAnswerCount(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord values(@NotNull Long value1, @NotNull String value2, @NotNull LocalDateTime value3, @NotNull LocalDateTime value4, @Nullable Integer value5, @Nullable Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LinkRecord
     */
    public LinkRecord() {
        super(Link.LINK);
    }

    /**
     * Create a detached, initialised LinkRecord
     */
    @ConstructorProperties({ "id", "link", "lastUpdate", "lastActivity", "openIssuesCount", "answerCount" })
    public LinkRecord(@NotNull Long id, @NotNull String link, @NotNull LocalDateTime lastUpdate, @NotNull LocalDateTime lastActivity, @Nullable Integer openIssuesCount, @Nullable Integer answerCount) {
        super(Link.LINK);

        setId(id);
        setLink(link);
        setLastUpdate(lastUpdate);
        setLastActivity(lastActivity);
        setOpenIssuesCount(openIssuesCount);
        setAnswerCount(answerCount);
    }

    /**
     * Create a detached, initialised LinkRecord
     */
    public LinkRecord(ru.tinkoff.edu.java.scrapper.domain.jooq.tables.pojos.Link value) {
        super(Link.LINK);

        if (value != null) {
            setId(value.getId());
            setLink(value.getLink());
            setLastUpdate(value.getLastUpdate());
            setLastActivity(value.getLastActivity());
            setOpenIssuesCount(value.getOpenIssuesCount());
            setAnswerCount(value.getAnswerCount());
        }
    }
}