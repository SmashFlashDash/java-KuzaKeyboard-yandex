import java.util.*;

public class Main {
    public static void main(String[] args) {
        String numChar = args[0];
        String idCharRaw = args[1];
        String idRowCharRaw = args[2];
        String numCharText = args[3];
        String idCharTextRaw = args[4];

        TreeMap<String, Set<String>> keyMap = new TreeMap<>();
        String[] charId = idCharRaw.split(" ");
        String[] charRow = idRowCharRaw.split(" ");
        for (int i = 0; i < charId.length; i++) {
            String row = charRow[i];
            String id = charId[i];
            Set<String> rowSet = keyMap.get(row);
            if (rowSet == null) {
                rowSet = new HashSet<>();
                rowSet.add(id);
                keyMap.put(row, rowSet);
            } else if (rowSet.contains(id)) {
            } else {
                rowSet.add(id);
            }
        }

        int keyDepth = 0;
        String[] idCharsText = idCharTextRaw.split(" ");
        String prevRowId = keyMap.entrySet().stream().filter(e -> e.getValue().contains(idCharsText[0]))
                .findFirst().map(Map.Entry::getKey).get();
        for (String charr : idCharsText) {
            if (!keyMap.get(prevRowId).contains(charr)) {
                keyDepth += 1;
                prevRowId = keyMap.entrySet().stream().filter(e -> e.getValue().contains(charr))
                        .findFirst().map(Map.Entry::getKey).get();
            }
        }
        System.exit(keyDepth);
    }
}
