package org.apache.http.entity;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.aaskrfyvhoypymnzlskbzwpyr;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class ContentType implements Serializable {
    private static final Map<String, ContentType> CONTENT_TYPE_MAP;
    public static final ContentType DEFAULT_BINARY;
    public static final ContentType DEFAULT_TEXT;
    private static final long serialVersionUID = -7768694718232371896L;
    private final Charset charset;
    private final String mimeType;
    private final NameValuePair[] params;
    public static final ContentType APPLICATION_ATOM_XML = create("application/atom+xml", aaskrfyvhoypymnzlskbzwpyr.ISO_8859_1);
    public static final ContentType APPLICATION_FORM_URLENCODED = create("application/x-www-form-urlencoded", aaskrfyvhoypymnzlskbzwpyr.ISO_8859_1);
    public static final ContentType APPLICATION_JSON = create("application/json", aaskrfyvhoypymnzlskbzwpyr.UTF_8);
    public static final ContentType APPLICATION_OCTET_STREAM = create("application/octet-stream", (Charset) null);
    public static final ContentType APPLICATION_SOAP_XML = create("application/soap+xml", aaskrfyvhoypymnzlskbzwpyr.UTF_8);
    public static final ContentType APPLICATION_SVG_XML = create("application/svg+xml", aaskrfyvhoypymnzlskbzwpyr.ISO_8859_1);
    public static final ContentType APPLICATION_XHTML_XML = create("application/xhtml+xml", aaskrfyvhoypymnzlskbzwpyr.ISO_8859_1);
    public static final ContentType APPLICATION_XML = create("application/xml", aaskrfyvhoypymnzlskbzwpyr.ISO_8859_1);
    public static final ContentType IMAGE_BMP = create("image/bmp");
    public static final ContentType IMAGE_GIF = create("image/gif");
    public static final ContentType IMAGE_JPEG = create("image/jpeg");
    public static final ContentType IMAGE_PNG = create("image/png");
    public static final ContentType IMAGE_SVG = create("image/svg+xml");
    public static final ContentType IMAGE_TIFF = create("image/tiff");
    public static final ContentType IMAGE_WEBP = create("image/webp");
    public static final ContentType MULTIPART_FORM_DATA = create("multipart/form-data", aaskrfyvhoypymnzlskbzwpyr.ISO_8859_1);
    public static final ContentType TEXT_HTML = create("text/html", aaskrfyvhoypymnzlskbzwpyr.ISO_8859_1);
    public static final ContentType TEXT_PLAIN = create(HTTP.PLAIN_TEXT_TYPE, aaskrfyvhoypymnzlskbzwpyr.ISO_8859_1);
    public static final ContentType TEXT_XML = create("text/xml", aaskrfyvhoypymnzlskbzwpyr.ISO_8859_1);
    public static final ContentType WILDCARD = create("*/*", (Charset) null);

    static {
        ContentType[] contentTypes = {APPLICATION_ATOM_XML, APPLICATION_FORM_URLENCODED, APPLICATION_JSON, APPLICATION_SVG_XML, APPLICATION_XHTML_XML, APPLICATION_XML, IMAGE_BMP, IMAGE_GIF, IMAGE_JPEG, IMAGE_PNG, IMAGE_SVG, IMAGE_TIFF, IMAGE_WEBP, MULTIPART_FORM_DATA, TEXT_HTML, TEXT_PLAIN, TEXT_XML};
        HashMap<String, ContentType> map = new HashMap<>();
        for (ContentType contentType : contentTypes) {
            map.put(contentType.getMimeType(), contentType);
        }
        CONTENT_TYPE_MAP = Collections.unmodifiableMap(map);
        DEFAULT_TEXT = TEXT_PLAIN;
        DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
    }

    ContentType(String mimeType, Charset charset) {
        this.mimeType = mimeType;
        this.charset = charset;
        this.params = null;
    }

    ContentType(String mimeType, Charset charset, NameValuePair[] params) {
        this.mimeType = mimeType;
        this.charset = charset;
        this.params = params;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getParameter(String name) {
        Args.notEmpty(name, "Parameter name");
        if (this.params == null) {
            return null;
        }
        NameValuePair[] arr$ = this.params;
        for (NameValuePair param : arr$) {
            if (param.getName().equalsIgnoreCase(name)) {
                return param.getValue();
            }
        }
        return null;
    }

    public String toString() {
        CharArrayBuffer buf = new CharArrayBuffer(64);
        buf.append(this.mimeType);
        if (this.params != null) {
            buf.append("; ");
            BasicHeaderValueFormatter.INSTANCE.formatParameters(buf, this.params, false);
        } else if (this.charset != null) {
            buf.append(HTTP.CHARSET_PARAM);
            buf.append(this.charset.name());
        }
        return buf.toString();
    }

    private static boolean valid(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '\"' || ch == ',' || ch == ';') {
                return false;
            }
        }
        return true;
    }

    public static ContentType create(String mimeType, Charset charset) {
        String normalizedMimeType = ((String) Args.notBlank(mimeType, "MIME type")).toLowerCase(Locale.ROOT);
        Args.check(valid(normalizedMimeType), "MIME type may not contain reserved characters");
        return new ContentType(normalizedMimeType, charset);
    }

    public static ContentType create(String mimeType) {
        return create(mimeType, (Charset) null);
    }

    public static ContentType create(String mimeType, String charset) throws UnsupportedCharsetException {
        return create(mimeType, !TextUtils.isBlank(charset) ? Charset.forName(charset) : null);
    }

    private static ContentType create(HeaderElement helem, boolean strict) {
        return create(helem.getName(), helem.getParameters(), strict);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        if (r8 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        if (r8.length <= 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        r2 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
    
        return new org.apache.http.entity.ContentType(r7, r0, r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.apache.http.entity.ContentType create(java.lang.String r7, org.apache.http.NameValuePair[] r8, boolean r9) {
        /*
            r0 = 0
            r1 = r8
            int r2 = r1.length
            r3 = 0
        L4:
            if (r3 >= r2) goto L2c
            r4 = r1[r3]
            java.lang.String r5 = r4.getName()
            java.lang.String r6 = "charset"
            boolean r5 = r5.equalsIgnoreCase(r6)
            if (r5 == 0) goto L29
            java.lang.String r5 = r4.getValue()
            boolean r6 = org.apache.http.util.TextUtils.isBlank(r5)
            if (r6 != 0) goto L2c
            java.nio.charset.Charset r6 = java.nio.charset.Charset.forName(r5)     // Catch: java.nio.charset.UnsupportedCharsetException -> L24
            r0 = r6
        L23:
            goto L2c
        L24:
            r6 = move-exception
            if (r9 != 0) goto L28
            goto L23
        L28:
            throw r6
        L29:
            int r3 = r3 + 1
            goto L4
        L2c:
            org.apache.http.entity.ContentType r1 = new org.apache.http.entity.ContentType
            if (r8 == 0) goto L35
            int r2 = r8.length
            if (r2 <= 0) goto L35
            r2 = r8
            goto L36
        L35:
            r2 = 0
        L36:
            r1.<init>(r7, r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.entity.ContentType.create(java.lang.String, org.apache.http.NameValuePair[], boolean):org.apache.http.entity.ContentType");
    }

    public static ContentType create(String mimeType, NameValuePair... params) throws UnsupportedCharsetException {
        String type = ((String) Args.notBlank(mimeType, "MIME type")).toLowerCase(Locale.ROOT);
        Args.check(valid(type), "MIME type may not contain reserved characters");
        return create(mimeType, params, true);
    }

    public static ContentType parse(String s) throws ParseException, UnsupportedCharsetException {
        Args.notNull(s, "Content type");
        CharArrayBuffer buf = new CharArrayBuffer(s.length());
        buf.append(s);
        ParserCursor cursor = new ParserCursor(0, s.length());
        HeaderElement[] elements = BasicHeaderValueParser.INSTANCE.parseElements(buf, cursor);
        if (elements.length > 0) {
            return create(elements[0], true);
        }
        throw new ParseException("Invalid content type: " + s);
    }

    public static ContentType get(HttpEntity entity) throws ParseException, UnsupportedCharsetException {
        Header header;
        if (entity != null && (header = entity.getContentType()) != null) {
            HeaderElement[] elements = header.getElements();
            if (elements.length > 0) {
                return create(elements[0], true);
            }
        }
        return null;
    }

    public static ContentType getLenient(HttpEntity entity) {
        Header header;
        if (entity != null && (header = entity.getContentType()) != null) {
            try {
                HeaderElement[] elements = header.getElements();
                if (elements.length > 0) {
                    return create(elements[0], false);
                }
            } catch (ParseException e) {
            }
        }
        return null;
    }

    public static ContentType getOrDefault(HttpEntity entity) throws ParseException, UnsupportedCharsetException {
        ContentType contentType = get(entity);
        return contentType != null ? contentType : DEFAULT_TEXT;
    }

    public static ContentType getLenientOrDefault(HttpEntity entity) throws ParseException, UnsupportedCharsetException {
        ContentType contentType = get(entity);
        return contentType != null ? contentType : DEFAULT_TEXT;
    }

    public static ContentType getByMimeType(String mimeType) {
        if (mimeType == null) {
            return null;
        }
        return CONTENT_TYPE_MAP.get(mimeType);
    }

    public ContentType withCharset(Charset charset) {
        return create(getMimeType(), charset);
    }

    public ContentType withCharset(String charset) {
        return create(getMimeType(), charset);
    }

    public ContentType withParameters(NameValuePair... params) throws UnsupportedCharsetException {
        if (params.length == 0) {
            return this;
        }
        Map<String, String> paramMap = new LinkedHashMap<>();
        if (this.params != null) {
            NameValuePair[] arr$ = this.params;
            for (NameValuePair param : arr$) {
                paramMap.put(param.getName(), param.getValue());
            }
        }
        for (NameValuePair param2 : params) {
            paramMap.put(param2.getName(), param2.getValue());
        }
        List<NameValuePair> newParams = new ArrayList<>(paramMap.size() + 1);
        if (this.charset != null && !paramMap.containsKey("charset")) {
            newParams.add(new BasicNameValuePair("charset", this.charset.name()));
        }
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            newParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return create(getMimeType(), (NameValuePair[]) newParams.toArray(new NameValuePair[newParams.size()]), true);
    }
}
