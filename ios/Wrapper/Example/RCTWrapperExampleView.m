//
//  RCTWrapperExampleView.m
//  NativeComp
//
//  Created by adrian.hartanto on 16/12/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import "RCTWrapperExampleView.h"

#import "RCTWrapper.h"

@implementation RCTWrapperExampleView {
  NSTimer *_timer;
  CGSize _intrinsicContentSize;
}

- (instancetype)initWithFrame:(CGRect)frame
{
  if (self = [super initWithFrame:frame]) {
    self.backgroundColor = [UIColor redColor];

    _intrinsicContentSize = CGSizeMake(64, 64);
    _timer = [NSTimer scheduledTimerWithTimeInterval:1.0
                                              target:self
                                            selector:@selector(tick)
                                            userInfo:nil
                                             repeats:YES];

    UITapGestureRecognizer *gestureRecognizer =
      [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(tick)];
    [self addGestureRecognizer:gestureRecognizer];
  }
  return self;
}

- (void)tick
{
  _intrinsicContentSize.width = 32 + arc4random() % 128;
  _intrinsicContentSize.height = 32 + arc4random() % 128;

  [self invalidateIntrinsicContentSize];
  [self.superview setNeedsLayout];
}

- (CGSize)intrinsicContentSize
{
  return _intrinsicContentSize;
}

- (CGSize)sizeThatFits:(CGSize)size
{
  return CGSizeMake(
    MIN(size.width, _intrinsicContentSize.width),
    MIN(size.height, _intrinsicContentSize.height)
  );
}

@end

RCT_WRAPPER_FOR_VIEW(RCTWrapperExampleView)
