class Twofer {
    String twofer(String name) {
        name = name == null ? "" : name;
        String result = "One for %s, one for me.";
        return name.equals("") ? String.format(result, "you") : String.format(result, name);
    }
}
