/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function (n) {
    let result = [];

    let backtrack = (str, open, close) => {
        if (str.length === 2 * n) {
            result.push(str);
            return;
        }
        if (open < n) {
            backtrack(str + "(", open + 1, close);
        }
        if (close < open) {
            backtrack(str + ")", open, close + 1);
        }
    }
    backtrack("", 0, 0);
    return result ;
};