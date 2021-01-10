class MicroBlog {

    public String truncate(String input) {
        StringBuilder newSb = new StringBuilder();
        input.codePoints().limit(5).forEach(x -> {
            newSb.appendCodePoint(x);
        });
        return newSb.toString();
    }
}
