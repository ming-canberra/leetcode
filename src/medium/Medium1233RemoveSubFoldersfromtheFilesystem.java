package medium;

import java.util.*;

public class Medium1233RemoveSubFoldersfromtheFilesystem {
    class Solution {
        public List<String> removeSubfolders(String[] folder) {
            TrieNode trie = new TrieNode();
            for (String fld : folder){
                TrieNode cur = trie;
                String paths[] = fld.split("/");
                for (String path : paths){
                    if (path.length() != 0){
                        TrieNode tmp = new TrieNode();
                        cur.children.put(path, cur.children.getOrDefault(path, tmp) );
                        cur = cur.children.get(path);
                    }
                }
                cur.isFolder = true;
            }
            List<String> result = new ArrayList<>();
            traverse(result, trie, "");
            return result;
        }
        private void traverse(List<String> result, TrieNode trie, String path){
            if (trie.isFolder){
                result.add(path);
            }
            else{
                for (String key : trie.children.keySet()){
                    traverse(result, trie.children.get(key), path + "/" + key);
                }
            }
        }
        class TrieNode{
            Map<String, TrieNode> children = new HashMap<>();
            boolean isFolder = false;
            public TrieNode(){
            }
        }
    }
}