import unittest
import day2


class MyTestCase(unittest.TestCase):
    def setUp(self):
        self.the_object = day2.Day2("inputTest.txt")

    def test_checksum(self):
        self.assertEqual(self.the_object.generate_checksum(), 12)

    def test_common_letters(self):
        self.assertEqual(self.the_object.common_letters(), 'abcde')


if __name__ == '__main__':
    unittest.main()
