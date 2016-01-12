package com.kantilever.t1c3android.rest;

/**
 * Created by Tom on 11-1-2016.
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

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
