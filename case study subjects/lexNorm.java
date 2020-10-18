  private long lexNorm(int[] c) {
            long ret = 0;
            for (int i = 0; i < c.length; i++) {
                final int digit = c[i];
                if (digit < 0 ||
                    digit >= n) {
                    throw new OutOfRangeException(digit, 0, n - 1);
                }

                ret += c[i] * ArithmeticUtils.pow(n, i);
            }
            return ret;
        }