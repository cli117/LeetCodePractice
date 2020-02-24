public class _ImplementTrie_208_IMPORTANT {
    private class TrieNode
    {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode()
        {
            links = new TrieNode[R];
            isEnd = false;
        }

        public boolean containsKey(char c)
        {
            return links[c - 'a'] != null;
        }

        public TrieNode get(char c)
        {
            return links[c - 'a'];
        }

        public void put(char c, TrieNode node)
        {
            links[c - 'a'] = node;
        }

        public void setEnd()
        {
            isEnd = true;
        }

        public boolean getEnd()
        {
            return isEnd;
        }
    }

    private class Trie
    {
        private TrieNode root;
        /** Initialize your data structure here. */
        public Trie()
        {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word)
        {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++)
            {
                char current = word.charAt(i);
                if (!node.containsKey(current))
                {
                    node.put(current, new TrieNode());
                }
                node = node.get(current);
            }
            node.setEnd();
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            boolean found = true;
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++)
            {
                char current = word.charAt(i);
                if (!node.containsKey(current))
                {
                    found = false;
                    break;
                }
                node = node.get(current);
            }
            if (!node.getEnd()) found = false;
            return found;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            boolean found = true;
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++)
            {
                char current = prefix.charAt(i);
                if (!node.containsKey(current))
                {
                    found = false;
                    break;
                }
                node = node.get(current);
            }
            return found;
        }
    }
}
