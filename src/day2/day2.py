from collections import defaultdict
import operator
import sys

class Day2:
    def __init__(self, input_filename):
        with open(input_filename) as f:
            self.lines = f.read().splitlines()

    def generate_checksum(self):
        counts = defaultdict(int)
        for line in self.lines:
            frequency = list(filter(lambda x: x > 1, set(map(line.count, line))))
            for item in frequency:
                counts[item] += 1
        return reduce(operator.mul, counts.values(), 1)

    def common_letters(self):
        def get_diff_characters(string1, string2):
            length = len(list(filter(lambda x: x is False,
                       map((lambda x: string1[x] == string2[x]), range(len(string1))))))
            string_pair = (string1, string2)
            return (length, string_pair)

        def get_common_string(string1, string2):
            common_string = ''
            for index in range(len(string1)):
                if(string1[index] == string2[index]):
                    common_string += string1[index]
            return common_string

        minimum_diff = sys.maxint
        closest_strings = ('', '')
        for line in self.lines:
            other_lines = self.lines
            other_lines.remove(line)
            closest_string_pair = sorted(map((lambda x: get_diff_characters(line, x)), other_lines))[0]
            if closest_string_pair[0] < minimum_diff:
                minimum_diff = closest_string_pair[0]
                closest_strings = closest_string_pair[1]

        return get_common_string(closest_strings[0],  closest_strings[1])

def main(input_filename = 'input.txt'):
    with open(input_filename) as f:
       day2 = Day2(input_filename)
       print(day2.generate_checksum())
       print(day2.common_letters())


if __name__ == '__main__':
    main()
