package com.kantilever.t1c3android.rest;

/**
 * The type Hateoas response.
 */
public class HateoasResponse {
    private Object content;

    /**
     * Create a response with content.
     *
     * @param content the content to wrap.
     */
    public HateoasResponse(final Object content) {
        this.content = content;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public Object getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(Object content) {
        this.content = content;
    }
}
