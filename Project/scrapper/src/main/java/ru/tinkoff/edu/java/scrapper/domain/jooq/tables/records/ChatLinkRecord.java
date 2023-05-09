/*
 * This file is generated by jOOQ.
 */
package ru.tinkoff.edu.java.scrapper.domain.jooq.tables.records;


import java.beans.ConstructorProperties;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import ru.tinkoff.edu.java.scrapper.domain.jooq.tables.ChatLink;


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
public class ChatLinkRecord extends UpdatableRecordImpl<ChatLinkRecord> implements Record3<Integer, Long, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>CHAT_LINK.ID</code>.
     */
    public void setId(@NotNull Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>CHAT_LINK.ID</code>.
     */
    @NotNull
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>CHAT_LINK.CHAT_ID</code>.
     */
    public void setChatId(@Nullable Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>CHAT_LINK.CHAT_ID</code>.
     */
    @Nullable
    public Long getChatId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>CHAT_LINK.LINK_ID</code>.
     */
    public void setLinkId(@Nullable Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>CHAT_LINK.LINK_ID</code>.
     */
    @Nullable
    public Long getLinkId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Row3<Integer, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    @NotNull
    public Row3<Integer, Long, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    @NotNull
    public Field<Integer> field1() {
        return ChatLink.CHAT_LINK.ID;
    }

    @Override
    @NotNull
    public Field<Long> field2() {
        return ChatLink.CHAT_LINK.CHAT_ID;
    }

    @Override
    @NotNull
    public Field<Long> field3() {
        return ChatLink.CHAT_LINK.LINK_ID;
    }

    @Override
    @NotNull
    public Integer component1() {
        return getId();
    }

    @Override
    @Nullable
    public Long component2() {
        return getChatId();
    }

    @Override
    @Nullable
    public Long component3() {
        return getLinkId();
    }

    @Override
    @NotNull
    public Integer value1() {
        return getId();
    }

    @Override
    @Nullable
    public Long value2() {
        return getChatId();
    }

    @Override
    @Nullable
    public Long value3() {
        return getLinkId();
    }

    @Override
    @NotNull
    public ChatLinkRecord value1(@NotNull Integer value) {
        setId(value);
        return this;
    }

    @Override
    @NotNull
    public ChatLinkRecord value2(@Nullable Long value) {
        setChatId(value);
        return this;
    }

    @Override
    @NotNull
    public ChatLinkRecord value3(@Nullable Long value) {
        setLinkId(value);
        return this;
    }

    @Override
    @NotNull
    public ChatLinkRecord values(@NotNull Integer value1, @Nullable Long value2, @Nullable Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ChatLinkRecord
     */
    public ChatLinkRecord() {
        super(ChatLink.CHAT_LINK);
    }

    /**
     * Create a detached, initialised ChatLinkRecord
     */
    @ConstructorProperties({ "id", "chatId", "linkId" })
    public ChatLinkRecord(@NotNull Integer id, @Nullable Long chatId, @Nullable Long linkId) {
        super(ChatLink.CHAT_LINK);

        setId(id);
        setChatId(chatId);
        setLinkId(linkId);
    }

    /**
     * Create a detached, initialised ChatLinkRecord
     */
    public ChatLinkRecord(ru.tinkoff.edu.java.scrapper.domain.jooq.tables.pojos.ChatLink value) {
        super(ChatLink.CHAT_LINK);

        if (value != null) {
            setId(value.getId());
            setChatId(value.getChatId());
            setLinkId(value.getLinkId());
        }
    }
}